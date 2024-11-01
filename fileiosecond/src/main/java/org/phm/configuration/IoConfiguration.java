package org.phm.configuration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.phm.exception.FileIoException;

public class IoConfiguration {

    public static final String FILE_PATH = "file.path";

    private static String getResourcePath() throws FileIoException {
        String filePath = System.getProperty(FILE_PATH);
        if (StringUtils.isBlank(filePath)) {
            throw new FileIoException("File path is empty or null");
        }
        return filePath;
    }

    public String getWritePath() throws FileIoException {
        return getResourcePath() + RandomStringUtils.randomAlphanumeric(17).toUpperCase() + ".txt";
    }
}
