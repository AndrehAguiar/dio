import socket

def start_server():
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    print('Socket created!')

    host = 'localhost'
    port = 5432

    s.bind((host, port))

    message = '\nServer: Server response to client'

    while 1:
        data, end = s.recvfrom(4096)

        if data:
            print('Server sending message...')
            s.sendto(data + (message.encode()), end)

if __name__ == "__main__":
    start_server()