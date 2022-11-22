FROM node:16-alpine
WORKDIR /frontend
COPY ./Apply-For-Me-UI .
RUN npm i
RUN npm run build
ENV NODE_ENV production
EXPOSE 3000
CMD [ "npm", "start"]