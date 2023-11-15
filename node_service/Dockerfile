# Node.js 18.16.0 버전을 기반으로 하는 이미지를 선택합니다.
FROM node:18.16.0

# 작업 디렉토리를 설정합니다.
WORKDIR /usr/src/app

# package.json과 package-lock.json(있는 경우)을 복사합니다.
COPY package*.json ./

# 프로젝트 의존성을 설치합니다.
RUN npm install

# 애플리케이션의 소스 코드를 Docker 이미지 내부로 복사합니다.
COPY . .

# pm2를 글로벌로 설치합니다.
RUN npm install pm2 -g

# 애플리케이션이 8080 포트에서 실행될 것이므로 이 포트를 노출합니다.
EXPOSE 8080

# pm2를 사용하여 애플리케이션을 실행하는 커맨드를 정의합니다.
CMD [ "pm2-runtime", "start", "npm", "--", "start" ]