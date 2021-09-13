import socket
import sys
# This is a sample Python script.

# Press Shift+F10  to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

def main():
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM, 0)
    except socket.error as err:
        print("A conexão falhou!!")
        print("Erro: {}".format(err))
        sys.exit()

    print("Socket criado com sucesso!!")
    host_alvo = input("Digite o Host ou Ip a ser conectado: ")
    porta_alvo = input("Digite o porta a ser conectado: ")

    try:
        s.connect((host_alvo, int(porta_alvo)))
        print(f"Client TCP com Sucesso no Host: {host_alvo} e na Porta: {porta_alvo}")
        s.shutdown(2)
    except socket.error as err:
        print(f"A conexão falhou no Host: {host_alvo} e na Porta: {porta_alvo}!")
        print(f"Erro: {err}")
        sys.exit()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
