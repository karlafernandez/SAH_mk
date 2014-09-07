from bs4 import BeautifulSoup
from selenium import webdriver
import re
import urllib2
import time
import os

baseurl = 'www.doomos.com.pe/kw/alquiler-habitacion-para-estudiante-arequipa.html'
page = urllib2.urlopen(baseurl)
soup = BeautifulSoup(page)
page.close()
SAHDivTag = soup.find_all('div', id=re.compile('SAH_'))
arrayNameSAH = []
if not os.path.exists('data/alquiler'):
				os.makedirs('data/alquiler')
if not os.path.exists('data/alquiler/pos'):
				os.makedirs('data/alquiler/pos')
if not os.path.exists('data/alquiler/neg'):
				os.makedirs('data/alquiler/neg')
for x in range(5, len(SAHDivTag)-1):
	SAH = SAHDivTag[x];
	soup2 = BeautifulSoup(str(SAH))
	SAHName = soup2.find('a', class_="property_title")
	if SAHName is not None:
		name = SAHName.contents[0].strip()
		arrayNameSAH.append(name)
		print '* '+name+' *'
		print '------------------------'
		SAHUrl = soup2.find('a', href=re.compile('/SAH_Review-'), id=re.compile('property_'))
		if SAHUrl is not None:
			hUrl = SAHUrl['href']
			i = 1
			j = 1
			oldPagina = "-Reviews-";
			while hUrl != '':
				browser = webdriver.Firefox()
				browser.get('http://www.doomos.com.pe/' + hUrl)
				time.sleep(3)
				SAHPage = browser.page_source
				browser.close()
				soup3 = BeautifulSoup(SAHPage)
				opinionUrlsSAH = soup3.find_all('a', href=re.compile('/ShowUserReviews-'), id=re.compile('rn'))
				arrayOpinionUrl = []
				print len(opinionUrlsSAH)
				for opinionUrl in opinionUrlsSAH:
					url = opinionUrl['href']
					arrayOpinionUrl.append(url)
					browser1 = webdriver.Firefox()
					browser1.get('http://www.doomos.com.pe/' + url)
					time.sleep(7)
					opinionPage = browser1.page_source
					browser1.close()
					#opinionPage = urllib2.urlopen('http://www.doomos.com.pe/' + url)
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
							f = open('data/SAHs/'+ foldSentiment  + '/'+ 'cv' + str(j) + '_' +name + '.txt','w')
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
				SAHUrls1 = soup3.find_all('a', href=re.compile(newUrl), class_=re.compile('paging'))
				hUrl = ''
				if len(SAHUrls1) != 0:
					hUrl = SAHUrls1[0]['href']
					i=i+1;
			print '------'
