import { Config } from 'protractor';
var reporter = require('cucumber-html-reporter')

export let config: Config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',

    directConnect: true,
    framework: 'custom',
    frameworkPath: require.resolve('protractor-cucumber-framework'),
 // Capabilities to be passed to the webdriver instance.
    capabilities: {
        browserName: 'chrome'
    },
    onComplete: ()=>{

      var options = {
        theme: 'bootstrap',
        jsonFile: './JSFiles/cucumberreport.json',
        output: './JSFiles/cucumber_report.html',
        reportSuiteAsScenarios: true,
        scenarioTimestamp: true,
        launchReport: true,
        metadata: {
            "App Version":"0.3.2",
            "Test Environment": "STAGING",
            "Browser": "Chrome  54.0.2840.98",
            "Platform": "Windows 10",
            "Parallel": "Scenarios",
            "Executed": "Remote"
        }
    };

    reporter.generate(options);
     },
    cucumberOpts: {
           tags: "@AngularTesting",
           format: 'json:./cucumberreport.json',
           
        // require step definitions
        require: [
          './stepDefinations/*.js' // accepts a glob
        ]
      },
    // Spec patterns are relative to the configuration file location passed
    // to protractor (in this example conf.js).
    // They may include glob patterns.
    specs: ['../test/demo.feature'],
}