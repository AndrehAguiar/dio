import hashlib


def get_files():
    global file1
    file1 = 'file1.txt'
    global file2
    file2 = 'file2.txt'
    print("#" * 100)
    print("FILES LOADED".center(100))
    print("#" * 100)
    return dict({'file1': file1, 'file2': file2})


def make_hash(files):
    hash1 = hashlib.new('ripemd160')
    hash1.update(open(files["file1"], 'rb').read())

    hash2 = hashlib.new('ripemd160')
    hash2.update(open(files["file2"], 'rb').read())

    print(f'{"-" * 100}\n')
    print(f"Hash 1: {hash1.hexdigest()}".center(100))
    print(f"Hash 2: {hash2.hexdigest()}".center(100))
    print(f'\n{"-" * 100}')
    return dict({'hash1': hash1, 'hash2': hash2})


def compare_hash(hashs):
    if hashs['hash1'].digest() != hashs['hash2'].digest():
        print(f'|{"="*24}> O arquivo: {file1} é diferente do {file2} <{"="*25}|'.center(100))
    else:
        print(f'|{"="*24}> O arquivo: {file1} é igual o {file2} <{"="*25}|'.center(100))

    print("=" * 100)


if __name__ == '__main__':
    compare_hash(make_hash(get_files()))


