import request from '@/utils/request'

// 查询鞋子管理列表
export function listShoes(query) {
  return request({
    url: '/clothes/shoes/list',
    method: 'get',
    params: query
  })
}

// 查询鞋子管理详细
export function getShoes(shoesId) {
  return request({
    url: '/clothes/shoes/' + shoesId,
    method: 'get'
  })
}

// 新增鞋子管理
export function addShoes(data) {
  return request({
    url: '/clothes/shoes',
    method: 'post',
    data: data
  })
}

// 修改鞋子管理
export function updateShoes(data) {
  return request({
    url: '/clothes/shoes',
    method: 'put',
    data: data
  })
}

// 删除鞋子管理
export function delShoes(shoesId) {
  return request({
    url: '/clothes/shoes/' + shoesId,
    method: 'delete'
  })
}
