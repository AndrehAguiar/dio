import socket


# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def main():
    # Use a breakpoint in the code line below to debug your script.
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    host = 'localhost'
    port = 5433
    message = 'Connect on server!!!'

    try:
        print(f"Client: {message}")
        s.sendto(message.encode(), (host, 5432))
        data, server = s.recvfrom(4096)
        data = data.decode()
        print(f"Client: {data}")
    finally:
        print("Client: Closing connection")
        s.close()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
