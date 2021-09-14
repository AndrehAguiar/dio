import webbrowser
from tkinter import *


def open_browser():
    root_tk = Tk()
    root_tk.title('Open Browser')
    root_tk.geometry('300x200')
    return root_tk


def google():
    webbrowser.open('www.google.com')


if __name__ == '__main__':
    root = open_browser()
    my_google = Button(root, text='Open Google', command=google).pack(pady=20)
    root.mainloop()
