// @Author: Zhang JunFeng
// @Date: 2021-01-06

// 时间格式转换
export function formatDate(date, fmt) {
  // 获取年份
  if (/(y+)/.test(fmt)) {
    // RegExp.$1  ——> 就是匹配到的结果： yyyy
    // date.getFullYear() + ''  ——>  将数字转化为字符串
    // substr(4 - RegExp.$1.length)  ——>  从第几位开始截取. 如果是 yy , 就从第2位开始截取
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
  }

  let o = {
    'M+': date.getMonth() + 1, // 月份从0开始计算
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  }
  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + ''
      fmt = fmt.replace(RegExp.$1, RegExp.$1.length === 1 ? str : padLeftZero(str))
    }
  }
  return fmt
}

function padLeftZero(str) {
  return ('00' + str).substr(str.length)
}
