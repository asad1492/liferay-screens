/**
* Copyright (c) 2000-present Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
import UIKit


class DDLFormLoadFormInteractor: ServerReadConnectorInteractor {

	var resultRecord: DDLRecord?
	var resultUserId: Int64?

	override func createConnector() -> ServerConnector {
		let screenlet = self.screenlet as! DDLFormScreenlet

		return LiferayServerContext.connectorFactory.createDDLFormLoadConnector(screenlet.structureId)
	}

	override func completedConnector(c: ServerConnector) {
		if let loadCon = c as? DDLFormLoadLiferayConnector {
			self.resultRecord = loadCon.resultRecord
			self.resultUserId = loadCon.resultUserId
		}
	}


	//MARK: Cache methods

	override func writeToCache(c: ServerConnector) {
		guard let cacheManager = SessionContext.currentContext?.cacheManager else {
			return
		}

		if let loadCon = c as? DDLFormLoadLiferayConnector,
				record = loadCon.resultRecord,
				userId = loadCon.resultUserId {

			cacheManager.setClean(
				collection: ScreenletName(DDLFormScreenlet),
				key: "structureId-\(loadCon.structureId)",
				value: record,
				attributes: [
					"userId": userId.description])
		}
	}

	override func readFromCache(c: ServerConnector, result: AnyObject? -> ()) {
		guard let cacheManager = SessionContext.currentContext?.cacheManager else {
			result(nil)
			return
		}

		if let loadCon = c as? DDLFormLoadLiferayConnector {
			cacheManager.getAnyWithAttributes(
					collection: ScreenletName(DDLFormScreenlet),
					key: "structureId-\(loadCon.structureId)") {
				record, attributes in

				loadCon.resultRecord = record as? DDLRecord
				loadCon.resultUserId = attributes?["userId"]?.longLongValue

				result(loadCon.resultRecord)
			}
		}
		else {
			result(nil)
		}
	}

}
