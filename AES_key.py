import codecs
from Crypto.Cipher import AES
import os

block_size = 16
path = os.path.abspath('file')
keys = []
matched_keys = []

plain_txt = "255044462d312e350a25d0d4c5d80a34"
cipher_txt = "d06bf9d0dab8e8ef880660d2af65aa82"
iv = codecs.decode("09080706050403020100A2B2C2D2E2F2", "hex")

with open('keyslist.txt') as w:
    for idx in w.read().splitlines():
        keys.append(idx)

decode_plain_txt = codecs.decode(plain_txt, "hex")

for key in keys:
    key = codecs.decode(key, "hex")
    enc_cipher = AES.new(key, AES.MODE_CBC, iv)
    cipher_text = enc_cipher.encrypt(decode_plain_txt)
    encrypted_code = cipher_text.hex()
    #print("The key word is: {} The encrypted code is: {} The cipher text is : {}".format(key, encrypted_code, cipher_txt))

    if encrypted_code == cipher_txt:
        matched_keys.append(key.hex())
        matched_keys = str(matched_keys).replace('[', '').replace(']', '')
        matched_encrypted_code = encrypted_code


print("The encrypted code is: {}".format(matched_encrypted_code))
print("The cipher text is : {}".format(cipher_txt))
print("The matched key word is: {}".format(matched_keys))

