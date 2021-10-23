#!/usr/local/bin/python3
"""
Please fill in MESSAGE and KEY as needed
"""
import base64

MESSAGE = ""  # base64 encoded message from Google

KEY = ""  # Your foobar username, usually your google username camel-cased

result = [chr(ord(c) ^ ord(KEY[i % len(KEY)])) for i, c in enumerate(base64.b64decode(MESSAGE).decode("utf-8"))]
print("".join(result))
