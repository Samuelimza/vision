package com.simul.vision.utils;

import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void fileReadTest() {
        assert FileUtils.getResourceUrl(StoredResources.MAIN_VIEW_FX) != null;
        assert FileUtils.getResourceUrl(StoredResources.GRAVITY_VIEW_FX) != null;
    }

}