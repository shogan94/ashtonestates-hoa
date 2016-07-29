/*
 *
 */
package org.ashtonestates.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.IterableUtils;
import org.ashtonestates.user.model.AshtonDocument;

public class AshtonUtils {

	public static ArrayList<AshtonDocument> getFileListing(final HttpSession session, final String path) {
		final File docFolder = new File(session.getServletContext().getRealPath(path));
		final File[] files = docFolder.listFiles();

		final ArrayList<AshtonDocument> docs = new ArrayList<AshtonDocument>();

		if (files != null) {
			final List<File> fileList = Arrays.asList(files);
			IterableUtils.forEach(fileList, input -> {
				final File file = input;
				docs.add(new AshtonDocument(file.getName(), file.lastModified(), file.length(), file.getName()));
			});
		}

		return docs;
	}
}
