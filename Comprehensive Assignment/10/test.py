from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoSuchElementException

def checkLogo(driver):
    try:
        driver.find_element(By.ID, "w3-logo")
    except NoSuchElementException:
        return False
    return True

driver = webdriver.Chrome()
driver.get("https://www.w3schools.com/")
assert (checkLogo(driver)) is True
driver.close()