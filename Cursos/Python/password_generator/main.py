import random
import string


def generate():
    pass_len = int(input("Digite o tamanho da senha que deseja: "))
    chars = f"{string.ascii_letters}{string.digits}!@#$%&*-=+,;:/?"
    rnd = random.SystemRandom()
    print(''.join(rnd.choice(chars) for i in range(pass_len)))


if __name__ == '__main__':
    generate()
