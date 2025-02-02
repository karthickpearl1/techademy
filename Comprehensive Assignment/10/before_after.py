import pytest
from selenium import webdriver

@pytest.fixture()
def driver_fixture(request):
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.w3schools.com")
    
    yield driver
    driver.quit()