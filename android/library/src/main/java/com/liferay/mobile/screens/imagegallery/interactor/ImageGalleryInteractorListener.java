/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.screens.imagegallery.interactor;

import com.liferay.mobile.screens.base.list.interactor.BaseListInteractorListener;
import com.liferay.mobile.screens.imagegallery.model.ImageEntry;

/**
 * @author Víctor Galán Grande
 */
public interface ImageGalleryInteractorListener extends BaseListInteractorListener<ImageEntry> {

	/**
	 * Called when an item in the list is deleted.
	 *
	 * @param imageEntryId
	 */
	void onImageEntryDeleted(long imageEntryId);

	/**
	 * Called when an item in the list was chosen and it's ready for upload.
	 *
	 * @param picturePath
	 */
	void onPicturePathReceived(String picturePath);

	/**
	 * Called when the item was successfully uploaded.
	 *
	 * @param entry
	 */
	void onPictureUploaded(ImageEntry entry);

	/**
	 * Retrieves constantly the progress until the picture is successfully uploaded.
	 * This method retrieves the bytes sent and the total.
	 *
	 * @param totalBytes
	 * @param totalBytesSent
	 */
	void onPictureUploadProgress(int totalBytes, int totalBytesSent);

	/**
	 * Called only once when user fill the upload form.
	 * This method retrieves the picture path, title, description and changelog.
	 *
	 * @param picturePath
	 * @param title
	 * @param description
	 * @param changelog
	 */
	void onPictureUploadInformationReceived(String picturePath, String title, String description, String changelog);
}
