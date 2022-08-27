FROM node:16.16.0
WORKDIR /frontend
COPY . .
COPY package.json ./
COPY package-lock.json ./
RUN npm i
EXPOSE 3000
CMD ["npm", "start"]
