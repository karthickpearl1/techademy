import pytest


def verify_checkbox(driver_fixture):
    checkboxes_link = driver_fixture.find_element_by_xpath("//a[contains(@href,'checkboxes')]")
    checkboxes_link.click()

    checkbox_list = driver_fixture.find_elements_by_id("checkboxes")

    # for checkbox in checkbox_list:
    #    assert (is_checked(checkbox)) is True

    assert (is_checked(checkbox_list[0])) is False
    assert (is_checked(checkbox_list[1])) is True

    driver_fixture.navigate.back()

def verify_upload(driver_fixture):
   file_upload_link = driver_fixture.find_element_by_xpath("//a[contains(@href,'upload')]")
   file_upload_link.click()

   header_text = driver_fixture.find_element_by_xpath("//h3")
   assert header_text == "File Uploader"

   select_file = driver_fixture.find_element_by_id("file-upload")
   select_file.send_keys("c:/temp/test.txt")

   upload_button = driver_fixture.find_element_by_id("file-submit")
   upload_button.click()

# Re-usable method to check if a checkbox element is checked or not
def is_checked(self, element):  
  return element.get_attribute("checked")