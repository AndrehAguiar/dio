import hashlib


def make_hash(option):
    text = input(f"{'_'*100}\nDigite o texto a ser transformado: ")

    if option == 1:
        digest = hashlib.md5(text.encode('utf-8'))
        print(f'O hash de {text} é, {digest.hexdigest()}')
    elif option == 2:
        digest = hashlib.sha1(text.encode('utf-8'))
        print(f'O hash de {text} é, {digest.hexdigest()}')
    elif option == 3:
        digest = hashlib.sha256(text.encode('utf-8'))
        print(f'O hash de {text} é, {digest.hexdigest()}')
    elif option == 4:
        digest = hashlib.sha512(text.encode('utf-8'))
        print(f'O hash de {text} é, {digest.hexdigest()}')
    else:
        print(f'{"¨"*100}\nOcorreu algum erro!\nConfirme se existe a opção  {option} e tente novamente')

    print("#"*100)


def menu():
    return int(input(f'''
{"MENU - ESCOLHA O TIPO DE HASH".center(100)}\n{"#"*100}\n
1) MD5\n2) SHA1\n3) SHA256\n4) SHA512\n{"="*100}
'''))


if __name__ == '__main__':
    make_hash(menu())
