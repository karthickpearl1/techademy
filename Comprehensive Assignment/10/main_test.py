import pytest
from before_after import driver_fixture
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoSuchElementException


def checkLogo(driver_fixture):
    try:
        driver_fixture.find_element(By.ID, "w3-logo")
    except NoSuchElementException:
        return False
    return True

def test_logo(driver_fixture):
    assert (checkLogo(driver_fixture)) is True