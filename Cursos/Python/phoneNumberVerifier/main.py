import phonenumbers
from phonenumbers import geocoder


def verify():
    phone_number = input('Digite o telefone no formato: +551100000000: ')
    phone_number = phonenumbers.parse(phone_number)
    print(geocoder.description_for_number(phone_number, 'pt'))


if __name__ == '__main__':
    verify()
