package com.mmihaylov.mobile_import_car_tool;

import com.mmihaylov.mobile_import_car_tool.model.MobileCarResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class MobileCarImportToolTest {

    Logger LOGGER = Logger.getLogger(MobileCarImportToolTest.class.getName());

    MobileCarImportTool mobileCarImportTool;

    @Before
    public void setUp() {
        this.mobileCarImportTool = MobileCarImportTool.getInstance();
    }

    @Test
    public void importFromMobileTest1() {
        try {
            String carUrl = "https://suchen.mobile.de/auto-inserat/volkswagen-golf-2-0-tsi-bmt-gti-keyfree-panoramadach-xenon-m%C3%BCnzenberg/283031666.html?action=homeRviReco";
            MobileCarResult mobileCarResult = this.mobileCarImportTool.importFromMobile(carUrl);
        } catch (MobileCarImportException e) {
            LOGGER.severe(e.getMessage());
            Assert.fail("Failed to get car info.");
        }
   }
}
