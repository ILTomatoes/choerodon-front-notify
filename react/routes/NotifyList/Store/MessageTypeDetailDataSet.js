import { DataSet } from 'choerodon-ui/pro/lib';

// const mockTemplate = `<!doctype html>
// <html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
// <head>
//   <title> </title>
//   <!--[if !mso]><!-- -->
//   <meta http-equiv="X-UA-Compatible" content="IE=edge">
//   <!--<![endif]-->
//   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
//   <meta name="viewport" content="width=device-width, initial-scale=1">
//   <style type="text/css">
//     #outlook a {
//       padding: 0;
//     }
//
//     .ReadMsgBody {
//       width: 100%;
//     }
//
//     .ExternalClass {
//       width: 100%;
//     }
//
//     .ExternalClass * {
//       line-height: 100%;
//     }
//
//     body {
//       margin: 0;
//       padding: 0;
//       -webkit-text-size-adjust: 100%;
//       -ms-text-size-adjust: 100%;
//     }
//
//     table,
//     td {
//       border-collapse: collapse;
//       mso-table-lspace: 0pt;
//       mso-table-rspace: 0pt;
//     }
//
//     img {
//       border: 0;
//       height: auto;
//       line-height: 100%;
//       outline: none;
//       text-decoration: none;
//       -ms-interpolation-mode: bicubic;
//     }
//
//     p {
//       display: block;
//       margin: 13px 0;
//     }
//   </style>
//   <!--[if !mso]><!-->
//   <style type="text/css">
//     @media only screen and (max-width:480px) {
//       @-ms-viewport {
//         width: 320px;
//       }
//       @viewport {
//         width: 320px;
//       }
//     }
//   </style>
//   <!--<![endif]-->
//   <!--[if mso]>
//   <xml>
//     <o:OfficeDocumentSettings>
//       <o:AllowPNG/>
//       <o:PixelsPerInch>96</o:PixelsPerInch>
//     </o:OfficeDocumentSettings>
//   </xml>
//   <![endif]-->
//   <!--[if lte mso 11]>
//   <style type="text/css">
//     .outlook-group-fix { width:100% !important; }
//   </style>
//   <![endif]-->
//   <!--[if !mso]><!-->
//   <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" rel="stylesheet" type="text/css">
//   <style type="text/css">
//     @import url(https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700);
//   </style>
//   <!--<![endif]-->
//   <style type="text/css">
//     @media only screen and (min-width:480px) {
//       .mj-column-per-100 {
//         width: 100% !important;
//         max-width: 100%;
//       }
//     }
//   </style>
//   <style type="text/css">
//   </style>
// </head>
//
// <body>
// <div style="">
//   <!--[if mso | IE]>
//   <table
//           align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:782px;" width="782"
//   >
//     <tr>
//       <td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;">
//   <![endif]-->
//   <div style="Margin:0px auto;max-width:782px;">
//     <table align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="width:100%;">
//       <tbody>
//       <tr>
//         <td style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;vertical-align:top;">
//           <!--[if mso | IE]>
//           <table role="presentation" border="0" cellpadding="0" cellspacing="0">
//
//             <tr>
//
//               <td
//                       class="" style="vertical-align:top;width:782px;"
//               >
//           <![endif]-->
//           <div class="mj-column-per-100 outlook-group-fix" style="font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
//             <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
//               <tr>
//                 <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
//                   <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#000000;">
//
//                     <body>
//                     <div style="width: 782px;
//       background: #FFFFFF;
//       margin: 0 auto;">
//                       <div style="height: 115px;
//       background-color: #ffffff;
//       border-bottom: 8px solid #3F51B5;">
//                         <table>
//                           <tr>
//                             <td style="padding-bottom: 0;vertical-align: bottom;">
//                               <table>
//                                 <tr>
//                                   <td style="width:190px;"> <img height="auto" src="https://file.choerodon.com.cn/static/choerodon.png" style="border:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;" width="190" /> </td>
//                                 </tr>
//                               </table>
//                             <td>
//                             <td style="vertical-align: bottom;">
//                               <div style="padding-top: 1px;margin-left: 10px; height: 90px; margin-top: 10px; ">
//                                 <p style="font-size: 14px;
//     color: #252528;
//     letter-spacing: 0;
//     display: inline-block;
//     text-align: right;
//     width: 558px;
//     padding-top: 55px;"></p >
//                               </div>
//                             </td>
//                           </tr>
//                         </table>
//                       </div>
//                       <div style="padding: 68px 40px;
//       border-bottom: 0;
//       border-top: 0;
//       border-left:1px solid #E6E6E6;
//       border-right:1px solid #E6E6E6;
//       border-radius: 2px;
//       background: #FFFFFF;">
//                         <div>
//                           <p style="margin-top: 0">亲爱的registrant用户，您好！</p >
//                           <p style="text-align: justify; margin-bottom: 0; line-height: 14px; font-size: 14px">非常感谢您对&nbsp;Choerodon&nbsp;的信任与支持！</p >
//                           <p style="text-align: justify; margin-bottom: 0; line-height: 14px; font-size: 14px">您在&nbsp;Choerodon&nbsp;提交的注册账号&nbsp;email&nbsp;经审核已通过，请您点击下方按钮完善您的个人信息。</p >
//                         </div>
//                         <div class="mj-column-per-100 outlook-group-fix" style="font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
//                           <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
//                             <tr>
//                               <td align="center" vertical-align="middle" style="font-size:0px;padding:10px 25px;padding-top:60px;word-break:break-word;">
//                                 <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="border-collapse:separate;width:212px;line-height:100%;">
//                                   <tr>
//                                     <td align="center" bgcolor="#3f51b5" role="presentation" style="border:none;border-radius:3px;cursor:auto;height:20px;padding:10px 25px;background:#3f51b5;" valign="middle"> <a href=" " style="background:#3f51b5;color:#ffffff;font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;font-weight:normal;line-height:120%;Margin:0;text-decoration:none;text-transform:none;" target="_blank">
//                                       点击完善信息
//                                     </a > </td>
//                                   </tr>
//                                 </table>
//                               </td>
//                             </tr>
//                           </table>
//                         </div>
//                       </div>
//                       <div>
//                         <div style="text-align: justify;">
//                           <table style="height: 148px; background-color: #f7f7f7;width: 100%;">
//                             <tr>
//                               <td style="padding-left: 29px;">
//                                 <table>
//                                   <tr>
//                                     <td> <img height="auto" style="border:0;display:block;outline:none;text-decoration:none;height:auto;width:90px;" width="90" src="https://file.choerodon.com.cn/static/wechat-code.jpg"> </tr>
//                                   <tr>
//                                     <td style="text-align: center">微信公众号</td>
//                                   </tr>
//                                 </table>
//                               <td>
//                               <td>
//                                 <div style="padding-top: 1px;margin-left: 10px; height: 90px; margin-top: 10px; vertical-align: top;">
//                                   <p style="font-size: 12px;
//       color: #626774;
//       letter-spacing: 0;
//       text-align: left;
//       margin-bottom: 6px;
//
//       margin-top: 0;"> 此邮件为系统邮件，请勿回复。 </p >
//                                   <p style="font-size: 12px;
//       color: #626774;
//       letter-spacing: 0;
//       text-align: left;
//       margin-bottom: 6px;
//
//       margin-top: 0;"> 如果您还尚未掌握Choerodon猪齿鱼的功能和操作，可以访问 <a style="text-decoration:none;font-size: 12px" href="http://choerodon.io/zh/" target="_blank">猪齿鱼官网</a >或 <a style="text-decoration:none;font-size: 12px" href="http://choerodon.io/zh/docs/"
//                                                                                                                                                                     target="_blank">帮助文档</a >。 </p >
//                                   <p style="font-size: 12px;
//       color: #626774;
//       letter-spacing: 0;
//       text-align: left;
//       margin-bottom: 6px;
//
//       margin-top: 0;"> 如果您需要任何帮助或者提供反馈, 请访问 <a style="text-decoration:none;font-size: 12px" href="http://forum.choerodon.io/" target="_blank">Choerodon论坛</a >。 </p >
//                                   <p style="font-size: 12px;
//       color: #626774;
//       letter-spacing: 0;
//       text-align: left;
//       margin-bottom: 6px;
//
//       margin-top: 0;">您也可以通过发送邮件的方式与我们联系：service@choerodon.com</p >
//                                 </div>
//                               </td>
//                             </tr>
//                           </table>
//                         </div>
//                       </div>
//                       <div style="width: 782px;
//       height: 34px;
//       background: #3F51B5;
//       ">
//                         <p style="opacity: 0.8;
//       font-size: 10px;
//       color: #FFFFFF;
//       text-align: center;
//       display: inline-block;
//       line-height: 34px;
//       width: 100%;
//       margin: 0 auto;">Copyright © The Choerodon Author. All rights reserved.</p >
//                       </div>
//                     </div>
//                     </body>
//                   </div>
//                 </td>
//               </tr>
//             </table>
//           </div>
//           <!--[if mso | IE]>
//           </td>
//
//           </tr>
//
//           </table>
//           <![endif]-->
//         </td>
//       </tr>
//       </tbody>
//     </table>
//   </div>
//   <!--[if mso | IE]>
//   </td>
//   </tr>
//   </table>
//   <![endif]-->
// </div>
// </body>
// </html>`;

export default function (templateDataSet) {
  return {
    autoQuery: false,
    selection: false,
    paging: false,
    children: {
      templates: templateDataSet,
    },
    fields: [{
      name: 'enabled',
      type: 'boolean',
    }, {
      name: 'allowConfig',
      type: 'boolean',
      label: '是否允许配置接收',
    }, {
      name: 'isSendInstantly',
      type: 'boolean',
      label: '是否即时发送',
    }, {
      name: 'retryCount',
      type: 'number',
      label: '邮件默认重发次数',
    }, {
      name: 'isManualRetry',
      type: 'boolean',
      label: '是否允许手动触发邮件',
    }, {
      name: 'backlogFlag',
      type: 'boolean',
      label: '是否为代办提醒',
    }, {
      name: 'aaa',
    }],
    transport: {
      read: {
        url: '/notify/v1/notices/send_settings/detail',
        method: 'get',
      },
    },
  };
}
