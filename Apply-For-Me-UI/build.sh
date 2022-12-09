#! /bin/bash

npm run build
npm install -g serve
serve -s build -p 7000