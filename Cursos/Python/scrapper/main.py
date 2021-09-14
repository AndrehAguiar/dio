from bs4 import BeautifulSoup
import requests


def scrappe(site):
    response = requests.get(site).content
    soup = BeautifulSoup(response, 'html.parser')
    print(soup.title.string)
    return soup


def get_temperatura(soup, el_dom, el_class):
    max_min = soup.find(el_dom, class_=el_class)
    print(soup.p.string)
    class_temp = ["Mínima", "Máxima"]
    max_min = [f'{class_temp[idx]} {str(max_min).splitlines()[el]}' for idx, el in enumerate([2, 4])]
    return max_min


if __name__ == '__main__':
    soup = scrappe("https://www.climatempo.com.br/")
    max_min = get_temperatura(soup, "p", "-gray _flex _align-center")
    print(" - ".join(max_min))
