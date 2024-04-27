import request from '@/utils/request'

// 查询装饰管理列表
export function listOrnament(query) {
  return request({
    url: '/clothes/ornament/list',
    method: 'get',
    params: query
  })
}

// 查询装饰管理详细
export function getOrnament(ornamentId) {
  return request({
    url: '/clothes/ornament/' + ornamentId,
    method: 'get'
  })
}

// 新增装饰管理
export function addOrnament(data) {
  return request({
    url: '/clothes/ornament',
    method: 'post',
    data: data
  })
}

// 修改装饰管理
export function updateOrnament(data) {
  return request({
    url: '/clothes/ornament',
    method: 'put',
    data: data
  })
}

// 删除装饰管理
export function delOrnament(ornamentId) {
  return request({
    url: '/clothes/ornament/' + ornamentId,
    method: 'delete'
  })
}
