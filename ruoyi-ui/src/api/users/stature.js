import request from '@/utils/request'

// 查询身材管理列表
export function listStature(query) {
  return request({
    url: '/users/stature/list',
    method: 'get',
    params: query
  })
}

// 查询身材管理详细
export function getStature(statureId) {
  return request({
    url: '/users/stature/' + statureId,
    method: 'get'
  })
}

// 新增身材管理
export function addStature(data) {
  return request({
    url: '/users/stature',
    method: 'post',
    data: data
  })
}

// 修改身材管理
export function updateStature(data) {
  return request({
    url: '/users/stature',
    method: 'put',
    data: data
  })
}

// 删除身材管理
export function delStature(statureId) {
  return request({
    url: '/users/stature/' + statureId,
    method: 'delete'
  })
}
