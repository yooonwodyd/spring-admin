
# GLOW 해커톤 - 가지도서관!
![gaji_logo](https://github.com/KongGookSu/frontend/assets/103253736/d165b63c-4bb0-4ed8-acc2-436855c2ab1c)

## 목차
- [개발 배경](#개발-배경)
- [상세 기능](#상세-기능)
- [기여자](#기여자)
- [기대효과](#기대효과)
  
### 개발 배경
#### 1. 독서 인구의 지속적인 감소
사람들의 독서가 줄어드는 이유
#### 2. 소도시의 도서관으로의 낮은 접근성

### 상세 기능 

### 기대 효과
#### 지방의 부족한 도서관을 대체하며 책의 접근성을 높인다.

#### 독서에 새로운 재미를 더하다.
책을 읽고, 읽은 책을 나누고, 책을 추천 받으며 독서의 새로운 즐거움을 가져옵니다.
![7430_105693_194](https://github.com/yooonwodyd/spring-admin/assets/103253736/d658f83d-1b78-41a9-9682-b74dfd012d4c)


### 기여자
|윤재용|김민주|심규민|채준혁|
|------|-------|-------|-------|
|![](https://avatars.githubusercontent.com/u/103253736?v=4)|![](https://avatars.githubusercontent.com/u/91789311?v=4)|(![](https://avatars.githubusercontent.com/u/49743742?v=4)|![](https://avatars.githubusercontent.com/u/18231524?v=4)|
|------|-------|-------|-------|










# React + TypeScript + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend updating the configuration to enable type aware lint rules:

- Configure the top-level `parserOptions` property like this:

```js
export default {
  // other rules...
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
    project: ['./tsconfig.json', './tsconfig.node.json'],
    tsconfigRootDir: __dirname,
  },
}
```

- Replace `plugin:@typescript-eslint/recommended` to `plugin:@typescript-eslint/recommended-type-checked` or `plugin:@typescript-eslint/strict-type-checked`
- Optionally add `plugin:@typescript-eslint/stylistic-type-checked`
- Install [eslint-plugin-react](https://github.com/jsx-eslint/eslint-plugin-react) and add `plugin:react/recommended` & `plugin:react/jsx-runtime` to the `extends` list
