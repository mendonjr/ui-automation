import { browser, element, by, By, $, $$, ExpectedConditions } from 'protractor';
import { angular } from './pageObjects/angularweb';
import { calculator } from './pageObjects/calculator';


describe('Protractor Demo', () => {
    it('Locators', async () => {

        browser.waitForAngularEnabled(false);

        //    browser.get('https://www.google.com/')
        let calc = new calculator()


        browser.get('https://juliemr.github.io/protractor-demo/');
        await calc.firstEditbox.sendKeys("4")
        await calc.secondEditbox.sendKeys("5")

        //await element(by.model("second")).sendKeys("4")

        //await element(by.model("operator")).element(by.css("option[value='MULTIPLICATION']")).click()  
        await calc.go.click().then(function () {

            browser.sleep(4000);
        })
        await calc.getResult.getText().then(function (text) {
            console.log(text)
        })

        await element(by.model("first")).sendKeys("5")

        await element(by.model("second")).sendKeys("4")
        await element(by.id("gobutton")).click()




        element(by.repeater("result in memory")).element(by.css("td:nth-child(3)")).getText().then(function (text) {
            console.log(text)
        })

    })
    it('Open Angular web page', async () => {




    })
    it('Angular home page title validation', async () => {
        let ah = new angular()
        browser.get('https://angularjs.org/')
        await ah.angularlink.click();
        await browser.sleep(4000)
        await ah.search.sendKeys("hello")



    })


})