#!/bin/bash


function randomHex() {
    printf %04X%02X `od -An -N2 -i < /dev/urandom` `od -An -N1 -i < /dev/urandom`
}

function serve() {
    while IFS='' read -r line || [[ -n "$line" ]]; do
        if [[ $line = *"GET /"* ]]; then
            echo "HTTP/1.1 200 OK"
            echo "Content-Type: text/html"
            echo -e "\r\n\r\n"
            echo "<html> <body> <div>"
            while :; do
                echo "<h3 style=\"color: `randomHex`; display: inline; border: solid 1px; border-color: `randomHex`\">Hello Bash</h3>"
                sleep 1
            done
            echo "</body> </html> </div>"
        fi
    done
}

if [[ $1 == "start" ]]; then
    netcat -l -p 8000 -e $0
    exit 0
fi
serve
