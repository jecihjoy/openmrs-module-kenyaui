/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.kenyaui;

import org.ocpsoft.prettytime.PrettyTime;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * UI utility methods
 */
@Component
public class KenyaUiUtils {

	private static final DateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");

	private static final DateFormat timeFormatter = new SimpleDateFormat("HH:mm");

	/**
	 * Sets the notification success message
	 * @param session the session
	 * @param message the message
	 */
	public void notifySuccess(HttpSession session, String message) {
		session.setAttribute(WebConstants.OPENMRS_MSG_ATTR, message);
	}

	/**
	 * Sets the notification error message
	 * @param session the session
	 * @param message the message
	 */
	public void notifyError(HttpSession session, String message) {
		session.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, message);
	}

	/**
	 * Formats a date time
	 * @param date the date
	 * @return the string value
	 */
	public String formatDateTime(Date date) {
		if (date == null)
			return "";

		return dateFormatter.format(date) + " " + timeFormatter.format(date);
	}

	/**
	 * Formats a date ignoring any time information
	 * @param date the date
	 * @return the string value
	 * @should format date as a string without time information
	 * @should format null date as empty string
	 */
	public String formatDate(Date date) {
		if (date == null)
			return "";

		return dateFormatter.format(date);
	}

	/**
	 * Formats a date as a time value only
	 * @param date the date
	 * @return the string value
	 * @should format date as a string without time information
	 */
	public String formatTime(Date date) {
		if (date == null)
			return "";

		return timeFormatter.format(date);
	}

	/**
	 * Formats a date interval
	 * @param date the date relative to now
	 */
	public String formatInterval(Date date) {
		PrettyTime t = new PrettyTime(new Date());
		return t.format(date);
	}
}