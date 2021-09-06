(()=>{"use strict";var e={3615:(e,t,r)=>{r(7280),r(5363),r(71);var o=r(8880),n=r(9592),a=r(3673);function i(e,t,r,o,n,i){const l=(0,a.up)("router-view");return(0,a.wg)(),(0,a.j4)(l)}var l=r(5777);class c extends l.w3{}c.render=i;const s=c;var u=r(7083),d=r(9582);const p=[{path:"/",component:()=>Promise.all([r.e(736),r.e(303)]).then(r.bind(r,2303)),children:[{path:"",component:()=>Promise.all([r.e(736),r.e(291)]).then(r.bind(r,1291))},{path:"/chat",component:()=>Promise.all([r.e(736),r.e(530)]).then(r.bind(r,6530))}]},{path:"/:catchAll(.*)*",component:()=>Promise.all([r.e(736),r.e(531)]).then(r.bind(r,531))}],f=p,h=(0,u.BC)((function(){const e=d.r5,t=(0,d.p7)({scrollBehavior:()=>({left:0,top:0}),routes:f,history:e("")});return t}));async function v(e,t){const r="function"===typeof h?await h({}):h,o=e(s);return o.use(n.Z,t),{app:o,router:r}}var b=r(2426),m=r(7760),g=r(6417),y=r(6249),w=r(8416);const P={config:{brand:{primary:"#325358",secondary:"#54a896",accent:"#6a1a78",dark:"#1d1d1d",positive:"#21BA45",negative:"#C10015",info:"#31CCEC",warning:"#cea32b"}},lang:b.Z,iconSet:m.Z,plugins:{Notify:g.Z,Loading:y.Z,AppFullscreen:w.Z}},O="";async function j({app:e,router:t},r){let o=!1;const n=e=>{o=!0;const r=Object(e)===e?t.resolve(e).fullPath:e;window.location.href=r},a=window.location.href.replace(window.location.origin,"");for(let l=0;!1===o&&l<r.length;l++)try{await r[l]({app:e,router:t,ssrContext:null,redirect:n,urlPath:a,publicPath:O})}catch(i){return i&&i.url?void(window.location.href=i.url):void console.error("[Quasar] boot error:",i)}!0!==o&&(e.use(t),e.mount("#q-app"))}v(o.ri,P).then((e=>Promise.all([Promise.resolve().then(r.bind(r,1768))]).then((t=>{const r=t.map((e=>e.default)).filter((e=>"function"===typeof e));j(e,r)}))))},1768:(e,t,r)=>{r.r(t),r.d(t,{default:()=>l,api:()=>i});var o=r(7083),n=r(52),a=r.n(n);const i=a().create({baseURL:"http://localhost:8080"}),l=(0,o.xr)((({app:e})=>{e.config.globalProperties.$axios=a(),e.config.globalProperties.$api=i}))}},t={};function r(o){var n=t[o];if(void 0!==n)return n.exports;var a=t[o]={exports:{}};return e[o](a,a.exports,r),a.exports}r.m=e,(()=>{var e=[];r.O=(t,o,n,a)=>{if(!o){var i=1/0;for(u=0;u<e.length;u++){for(var[o,n,a]=e[u],l=!0,c=0;c<o.length;c++)(!1&a||i>=a)&&Object.keys(r.O).every((e=>r.O[e](o[c])))?o.splice(c--,1):(l=!1,a<i&&(i=a));if(l){e.splice(u--,1);var s=n();void 0!==s&&(t=s)}}return t}a=a||0;for(var u=e.length;u>0&&e[u-1][2]>a;u--)e[u]=e[u-1];e[u]=[o,n,a]}})(),(()=>{r.n=e=>{var t=e&&e.__esModule?()=>e["default"]:()=>e;return r.d(t,{a:t}),t}})(),(()=>{r.d=(e,t)=>{for(var o in t)r.o(t,o)&&!r.o(e,o)&&Object.defineProperty(e,o,{enumerable:!0,get:t[o]})}})(),(()=>{r.f={},r.e=e=>Promise.all(Object.keys(r.f).reduce(((t,o)=>(r.f[o](e,t),t)),[]))})(),(()=>{r.u=e=>"js/"+e+"."+{291:"a38d5262",303:"952f6542",530:"d752ab28",531:"1919fbaf"}[e]+".js"})(),(()=>{r.miniCssF=e=>"css/vendor.27db5965.css"})(),(()=>{r.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()})(),(()=>{r.o=(e,t)=>Object.prototype.hasOwnProperty.call(e,t)})(),(()=>{var e={},t="chatbot:";r.l=(o,n,a,i)=>{if(e[o])e[o].push(n);else{var l,c;if(void 0!==a)for(var s=document.getElementsByTagName("script"),u=0;u<s.length;u++){var d=s[u];if(d.getAttribute("src")==o||d.getAttribute("data-webpack")==t+a){l=d;break}}l||(c=!0,l=document.createElement("script"),l.charset="utf-8",l.timeout=120,r.nc&&l.setAttribute("nonce",r.nc),l.setAttribute("data-webpack",t+a),l.src=o),e[o]=[n];var p=(t,r)=>{l.onerror=l.onload=null,clearTimeout(f);var n=e[o];if(delete e[o],l.parentNode&&l.parentNode.removeChild(l),n&&n.forEach((e=>e(r))),t)return t(r)},f=setTimeout(p.bind(null,void 0,{type:"timeout",target:l}),12e4);l.onerror=p.bind(null,l.onerror),l.onload=p.bind(null,l.onload),c&&document.head.appendChild(l)}}})(),(()=>{r.r=e=>{"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})}})(),(()=>{r.p=""})(),(()=>{var e={143:0};r.f.j=(t,o)=>{var n=r.o(e,t)?e[t]:void 0;if(0!==n)if(n)o.push(n[2]);else{var a=new Promise(((r,o)=>n=e[t]=[r,o]));o.push(n[2]=a);var i=r.p+r.u(t),l=new Error,c=o=>{if(r.o(e,t)&&(n=e[t],0!==n&&(e[t]=void 0),n)){var a=o&&("load"===o.type?"missing":o.type),i=o&&o.target&&o.target.src;l.message="Loading chunk "+t+" failed.\n("+a+": "+i+")",l.name="ChunkLoadError",l.type=a,l.request=i,n[1](l)}};r.l(i,c,"chunk-"+t,t)}},r.O.j=t=>0===e[t];var t=(t,o)=>{var n,a,[i,l,c]=o,s=0;if(i.some((t=>0!==e[t]))){for(n in l)r.o(l,n)&&(r.m[n]=l[n]);if(c)var u=c(r)}for(t&&t(o);s<i.length;s++)a=i[s],r.o(e,a)&&e[a]&&e[a][0](),e[i[s]]=0;return r.O(u)},o=self["webpackChunkchatbot"]=self["webpackChunkchatbot"]||[];o.forEach(t.bind(null,0)),o.push=t.bind(null,o.push.bind(o))})();var o=r.O(void 0,[736],(()=>r(3615)));o=r.O(o)})();