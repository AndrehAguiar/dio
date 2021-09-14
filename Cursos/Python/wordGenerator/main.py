import itertools


def generate(text):
    [print(''.join(result)) for result in itertools.permutations(text, len(text))]


if __name__ == '__main__':
    generate(input("Informe 0 texto a ser permutado: "))
