import request from '@/utils/request'

// 查询tops列表
export function listTops(query) {
  return request({
    url: '/clothes/tops/list',
    method: 'get',
    params: query
  })
}

// 查询tops详细
export function getTops(topsId) {
  return request({
    url: '/clothes/tops/' + topsId,
    method: 'get'
  })
}

// 新增tops
export function addTops(data) {
  return request({
    url: '/clothes/tops',
    method: 'post',
    data: data
  })
}

// 修改tops
export function updateTops(data) {
  return request({
    url: '/clothes/tops',
    method: 'put',
    data: data
  })
}

// 删除tops
export function delTops(topsId) {
  return request({
    url: '/clothes/tops/' + topsId,
    method: 'delete'
  })
}
