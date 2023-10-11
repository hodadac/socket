import requests
from bs4 import BeautifulSoup

url = "https://news.jtbc.co.kr/article/article.aspx?news_id=NB12146294"

response = requests.get(url)

if response.status_code==200:
    html = response.text
    soup = BeautifulSoup(html,'html.parser')
    title = soup.select_one('#articletitle > div > #jtbcBody').get_text()
    content = soup.select_one('#ijam_content').get_text()
    print(content)