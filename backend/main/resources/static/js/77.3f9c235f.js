"use strict";(self["webpackChunkchatbot"]=self["webpackChunkchatbot"]||[]).push([[77],{2077:(e,t,a)=>{a.r(t),a.d(t,{default:()=>S});var n=a(3673);const o={class:"q-pa-md",style:{"max-width":"650px"}},l={class:"q-ma-md"},m=(0,n._)("div",{class:"text-h6"},"SUKAPP Chat Messenger",-1),r={class:"q-pa-md row justify-center"},s={style:{width:"550px","max-width":"550px"}};function u(e,t,a,u,i,c){const d=(0,n.up)("q-separator"),h=(0,n.up)("q-chat-message"),p=(0,n.up)("q-scroll-area"),y=(0,n.up)("q-card-section"),w=(0,n.up)("q-card"),x=(0,n.up)("q-input"),g=(0,n.up)("q-toggle"),f=(0,n.up)("q-btn"),b=(0,n.up)("q-form"),W=(0,n.up)("q-page");return(0,n.wg)(),(0,n.j4)(W,{class:"row items-center justify-evenly"},{default:(0,n.w5)((()=>[(0,n._)("div",o,[(0,n.Wm)(b,{onSubmit:u.onSubmit,onReset:u.onReset,class:"q-gutter-md"},{default:(0,n.w5)((()=>[(0,n._)("div",l,[(0,n.Wm)(w,{class:"my-card text-white",style:{background:"radial-gradient(circle, #4c4c4c 0%, #333333 100%)","max-width":"650px",width:"650px"}},{default:(0,n.w5)((()=>[(0,n.Wm)(y,null,{default:(0,n.w5)((()=>[m,(0,n.Wm)(d,{spaced:"",inset:""}),(0,n.Wm)(p,{"thumb-style":e.thumbStyle,"bar-style":e.barStyle,style:{height:"550px","max-width":"625px",width:"625px"}},{default:(0,n.w5)((()=>[(0,n._)("div",r,[(0,n._)("div",s,[(0,n.Wm)(h,{name:"me",text:["hey, how are you?"],sent:""}),(0,n.Wm)(h,{name:"Jane",text:["doing fine, how r you?"]}),(0,n.Wm)(h,{name:"me",text:["hey, how are you?"],sent:""}),(0,n.Wm)(h,{name:"Jane",text:["doing fine, how r you?"]}),(0,n.Wm)(h,{name:"me",text:["hey, how are you?"],sent:""}),(0,n.Wm)(h,{name:"Jane",text:["doing fine, how r you?"]}),(0,n.Wm)(h,{name:"me",text:["hey, how are you?"],sent:""}),(0,n.Wm)(h,{name:"Jane",text:["doing fine, how r you?"]}),(0,n.Wm)(h,{name:"me",text:["hey, how are you?"],sent:""}),(0,n.Wm)(h,{name:"Jane",text:["doing fine, how r you?"]}),(0,n.Wm)(h,{name:"me",text:["hey, how are you?"],sent:""}),(0,n.Wm)(h,{name:"Jane",text:["doing fine, how r you?"]})])])])),_:1},8,["thumb-style","bar-style"])])),_:1})])),_:1})]),(0,n.Wm)(x,{filled:"",modelValue:u.m_chatEntry,"onUpdate:modelValue":t[0]||(t[0]=e=>u.m_chatEntry=e),label:"Enter Chat Message!"},null,8,["modelValue"]),(0,n.Wm)(g,{modelValue:u.accept,"onUpdate:modelValue":t[1]||(t[1]=e=>u.accept=e),label:"I accept the license and terms"},null,8,["modelValue"]),(0,n._)("div",null,[(0,n.Wm)(f,{label:"Submit",type:"submit",color:"primary"})])])),_:1},8,["onSubmit","onReset"])])])),_:1})}var i=a(8825),c=a(1959);const d={setup(){const e=(0,i.Z)(),t=(0,c.iH)(null),a=(0,c.iH)(!1);return{m_chatEntry:t,accept:a,onSubmit(){let n=String(t.value);n.length<=0?e.notify({color:"red-1",textColor:"white",icon:"error",message:"You need to enter valid text no?"}):!0!==a.value?e.notify({color:"red-5",textColor:"white",icon:"warning",message:"You need to accept the license and terms first"}):e.notify({color:"green-4",textColor:"white",icon:"cloud_done",message:"Submitted"})},onReset(){t.value=null,a.value=!1}}}};var h=a(4379),p=a(8689),y=a(151),w=a(5589),x=a(5869),g=a(7704),f=a(629),b=a(1206),W=a(2582),v=a(522),_=a(7518),q=a.n(_);d.render=u;const S=d;q()(d,"components",{QPage:h.Z,QForm:p.Z,QCard:y.Z,QCardSection:w.Z,QSeparator:x.Z,QScrollArea:g.Z,QChatMessage:f.Z,QInput:b.Z,QToggle:W.Z,QBtn:v.Z})}}]);