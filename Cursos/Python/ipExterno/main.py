import re
import json
from urllib.request import urlopen


def get_ip(url):
    response = urlopen(url)
    data = json.load(response)
    ip = data['ip']
    org = data['org']
    city = data['city']
    country = data['country']
    region = data['region']

    print('Detalhes do IP externo')
    print(f'IP: {ip}\nOrg: {org}\nCity: {city}\nCountry: {country}\nRegion: {region}')


if __name__ == '__main__':
    get_ip('https://ipinfo.io/json')
