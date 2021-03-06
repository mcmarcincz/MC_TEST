package stepdefs

import geb.Browser
import geb.binding.BindingUpdater
import geb.driver.CachingDriverFactory

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

Before() {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
}

After() {
    println("Clearing cache and closing browser...")
    def cachedDriver = CachingDriverFactory.clearCacheAndQuitDriver()
    bindingUpdater.remove()
}


After('@CleanUp'){
    bindingUpdater.browser.clearCookies()
    CachingDriverFactory.clearCache()
    bindingUpdater.browser.quit()
}