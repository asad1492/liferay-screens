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

package com.liferay.mobile.screens.dlfile.display.image;

import android.widget.ImageView;
import com.liferay.mobile.screens.dlfile.display.BaseFileDisplayViewModel;

/**
 * @author Sarai Díaz García
 */
public interface ImageDisplayViewModel extends BaseFileDisplayViewModel {

	/**
	 * Sets the {@link ImageView.ScaleType} for the image.
	 *
	 * @param scaleType
	 */
	void setScaleType(ImageView.ScaleType scaleType);

	/**
	 * Sets the placeholder image resource.
	 *
	 * @param placeholder
	 */
	void setPlaceholder(int placeholder);

	/**
	 * Sets the placeholder image {@link ImageView.ScaleType}.
	 *
	 * @param placeholderScaleType
	 */
	void setPlaceholderScaleType(ImageView.ScaleType placeholderScaleType);
}
