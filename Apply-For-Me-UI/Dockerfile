FROM node:16-alpine

RUN mkdir -p /frontend

WORKDIR /frontend

COPY . .

RUN rm package-lock.json

RUN npm i

#RUN npm run build
ENV NODE_ENV production

EXPOSE 3000

CMD [ "npm", "start"]