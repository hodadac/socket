from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

import time

driver = webdriver.Chrome()

driver.get("https://www.koreabaseball.com/Schedule/Schedule.aspx")
time.sleep(3)
