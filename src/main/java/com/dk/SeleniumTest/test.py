import time

from selenium import webdriver
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary

# referenece : https://greeksharifa.github.io/references/2020/10/30/python-selenium-usage/
# reference : https://greeksharifa.github.io/references/2020/10/30/python-selenium-usage/#%ED%81%B4%EB%A6%AD%ED%95%98%EA%B8%B0click
if __name__ == '__main__':

    driver = webdriver.Firefox(executable_path='D:\geckodriver-v0.29.1-win64\geckodriver.exe', timeout=0)
    driver.get("https://easybooking.naver.com/")

    # Wait for Login Complete
    target_words = "booking-calendar-view"
    count = 0
    while(True):
        if target_words in driver.current_url:
            print("Get Target URL. " + driver.current_url + " Now. Start to Work.")
            break

        # Wait for sec
        time.sleep(5000)
        count += 1

    # switch to booking list view
    list_view_url = "https://partner.booking.naver.com/bizes/162405/booking-list-view"
    driver.get(list_view_url)


    # select booking status
    book_status_btn_id = "dropdownBookingStatus"
    driver.find_element_by_id(book_status_btn_id).click()

    # Select Confirm status
    confirm_status_btn_xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[3]"
    driver.find_element_by_xpath(confirm_status_btn_xpath).click()

    # get text data info
    date_status_xpath = '//*[@id="dropdownBookingState"]'
    driver.find_element_by_xpath(date_status_xpath).text
    date_start_xpath = '//*[@id="app"]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/span'
    driver.find_element_by_xpath(date_start_xpath).text
    date_end_xpath = '//*[@id="app"]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div/div/div[3]/span[2]'
    driver.find_element_by_xpath(date_end_xpath).text
    total_result_count_xpath = '//*[@id="app"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/span/em'
    driver.find_element_by_xpath(total_result_count_xpath).text


    # Get Customer Info Row
    row_class = "flex-nowrap"
    row_list = driver.find_elements_by_class_name(row_class)
    customer_rows = []
    for i in row_list:
        if i.tag_name == 'div':
            if "BookingListView__contents" in i.get_attribute("class"):
                customer_rows.append(i)

    customer_rows[0].find_element_by_class_name("BookingListView__name")


    for i in driver.find_elements_by_class_name("align-self-center"):
        if i.tag_name == 'div' and "BookingListView__name" in i.get_attribute("class"):
            i.text



    customer_info_row_class = "BookingListView__contents-inner__11KKD d-flex"
    driver.find_element_by_class_name(customer_info_row_class)
    driver.find_elements_by_class_name(customer_info_row_class)

    customer_info_row_xpath = '//*[@id="app"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/div[2]'
    driver.find_elements_by_xpath(customer_info_row_xpath)
