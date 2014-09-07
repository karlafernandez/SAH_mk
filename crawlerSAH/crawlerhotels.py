from bs4 import BeautifulSoup
from selenium import webdriver
import re
import urllib2
import time
import os

baseurl = 'http://www.tripadvisor.com.pe/Hotels-g294313-Arequipa_Arequipa_Region-Hotels.html'
page = urllib2.urlopen(baseurl)
soup = BeautifulSoup(page)
page.close()
hotelDivTag = soup.find_all('div', id=re.compile('hotel_'))
arrayNameHotel = []
if not os.path.exists('data/hotels'):
				os.makedirs('data/hotels')
if not os.path.exists('data/hotels/pos'):
				os.makedirs('data/hotels/pos')
if not os.path.exists('data/hotels/neg'):
				os.makedirs('data/hotels/neg')
for x in range(5, len(hotelDivTag)-1):
	hotel = hotelDivTag[x];
	soup2 = BeautifulSoup(str(hotel))
	hotelName = soup2.find('a', class_="property_title")
	if hotelName is not None:
		name = hotelName.contents[0].strip()
		arrayNameHotel.append(name)
		print '* '+name+' *'
		print '------------------------'
		hotelUrl = soup2.find('a', href=re.compile('/Hotel_Review-'), id=re.compile('property_'))
		if hotelUrl is not None:
			hUrl = hotelUrl['href']
			i = 1
			j = 1
			oldPagina = "-Reviews-";
			while hUrl != '':
				browser = webdriver.Firefox()
				browser.get('http://www.tripadvisor.com.pe' + hUrl)
				time.sleep(3)
				hotelPage = browser.page_source
				browser.close()
				soup3 = BeautifulSoup(hotelPage)
				opinionUrlsHotel = soup3.find_all('a', href=re.compile('/ShowUserReviews-'), id=re.compile('rn'))
				arrayOpinionUrl = []
				print len(opinionUrlsHotel)
				for opinionUrl in opinionUrlsHotel:
					url = opinionUrl['href']
					arrayOpinionUrl.append(url)
					browser1 = webdriver.Firefox()
					browser1.get('http://www.tripadvisor.com.pe' + url)
					time.sleep(7)
					opinionPage = browser1.page_source
					browser1.close()
					#opinionPage = urllib2.urlopen('http://www.tripadvisor.com.pe' + url)
					soup4 = BeautifulSoup(opinionPage)
					opinion = soup4.find('div', id=re.compile('review_'))
					if opinion is not None:
						soup5 = BeautifulSoup(str(opinion))
						userId = soup5.find('div', property="v:reviewer")
						summary = soup5.find('div', property="v:summary")
						#rating = soup5.find('img', property="v:rating")
						rating = soup5.find('img', class_=re.compile('rating'))
						ratingList = soup5.findall('img', class_=re.compile('sprite-rating_ss_fill rating_ss_fill ss50'))
						if rating is not None:
							rati = rating['alt'][:1]
							dateopinion = soup5.find('span', property="v:dtreviewed")
							description = soup5.find('p', property="v:description")
							description1 = soup5.find('p', id=re.compile('review_'))
							foldSentiment = ''
							if rati == '5':
								foldSentiment = 'pos';
							else:
								foldSentiment = 'neg';
							f = open('data/hotels/'+ foldSentiment  + '/'+ 'cv' + str(j) + '_' +name + '.txt','w')
							if description is not None:
								#print str(j) + description.contents[0]
								#f.write(str(rati) + ' ' + description.contents[0].encode('utf-8').strip()+'\n')
								f.write(description.contents[0].encode('utf-8').strip()+'\n')
							elif description1 is not None:
								f.write(description1.contents[0].encode('utf-8').strip()+'\n')
							f.close()
							j=j+1
				#print "\n"
				pagina = 10*i;
				newPagina = "-Reviews-or"+`pagina`+"-";
				newUrl =  hUrl.replace(oldPagina, newPagina);
				oldPagina = newPagina;
				hotelUrls1 = soup3.find_all('a', href=re.compile(newUrl), class_=re.compile('paging'))
				hUrl = ''
				if len(hotelUrls1) != 0:
					hUrl = hotelUrls1[0]['href']
					i=i+1;
			print '------'
