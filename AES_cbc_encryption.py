import codecs
from Crypto.Cipher import AES
import os

block_size = 16
path = os.path.abspath('file')
keys = []
matched_keys = []
iv = codecs.decode("010203040506070809000a0b0c0d0e0f", "hex")


def pad(data):
    paddable_len = (block_size - len(data)) % block_size
    fillers = chr(paddable_len).encode('ascii', errors='replace').decode("utf-8")
    pad_data = data + (paddable_len * fillers)
    return pad_data


with open(path) as f:
    plain_txt = f.read()

with open('words.txt') as w:
    for idx in w.read().splitlines():
        keys.append(idx)

with open('ciphertext6.bin', 'rb') as f:
    text = f.read()
    ciphertext_utf_8 = text
    cipher_txt = text.hex()


def padding(text):
    paddable_len = (block_size - len(text)) % block_size
    total_len = len(text) + paddable_len
    padding = text.ljust(total_len, '#')
    return padding


for key in keys:
    key = padding(key).encode("utf-8")
    enc_cipher = AES.new(key, AES.MODE_CBC, iv)
    cipher_text = enc_cipher.encrypt(str(pad(plain_txt)).encode("utf-8"))
    encrypted_code = cipher_text.hex()
    print("The key word is: {} The encrypted code is: {} The cipher text is : {}".format(key, encrypted_code, cipher_txt))

    if encrypted_code == cipher_txt:
        matched_keys.append(key.rstrip(b'#').decode())
        matched_encrypted_code = encrypted_code


print("The matched key word is: {} The encrypted code is: {} The cipher text is : {}".format(matched_keys, matched_encrypted_code, cipher_txt))

