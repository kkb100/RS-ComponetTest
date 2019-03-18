package com.RSComponet.app.steps.Hooks;

import com.RSComponet.app.Infrastructure.BrowserConfig.BrowserFactory;
import com.RSComponet.app.Infrastructure.filereader.ConfigReader;
import com.RSComponet.app.PageObject.PageDomain;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class RS_Hooks {

    private BrowserFactory browserFactory;

    @Before
    public void testSetUp() throws Throwable {
        String browser = ConfigReader.getObjectRepoValue("rscomponent.dev.default.browser");
        String executionArea = ConfigReader.getObjectRepoValue("rscomponent.dev.exec.env.location");
        String machineType = ConfigReader.getObjectRepoValue("rscomponent.dev.machine.type");
        String remotePlace = ConfigReader.getObjectRepoValue("rscomponent.dev.remote.place");
        this.browserFactory = new BrowserFactory();
        new PageDomain(browserFactory.setUpBrowser
                (browser, executionArea, machineType, remotePlace)).RegisterPageObjects();
    }

    @After
    public void testCleanUp() {
        browserFactory.tearDownBrowser();
    }
}
