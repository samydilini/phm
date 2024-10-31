package org.phm.configuration;

import org.apache.commons.lang3.StringUtils;
import org.phm.exception.FileIoException;

public class IoConfiguration {
    public String getReadFilePath() throws FileIoException {
        String filePath = System.getProperty("file.path");
        if (StringUtils.isBlank(filePath)) {
            throw new FileIoException("File path is empty or null");
        }
        return filePath;
    }
}
