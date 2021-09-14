import ctypes


def hide():
    att_ocultar = 0x02
    att_somente_leitura = 0x01
    att_mostrar = 0x00

    result = ctypes.windll.kernel32.SetFileAttributesW('ocultar.txt', att_ocultar)
    print(result)
    if result:
        print("File hidden")
    else:
        print("File not hidden")


if __name__ == '__main__':
    hide()
