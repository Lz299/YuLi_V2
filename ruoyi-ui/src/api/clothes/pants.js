import request from '@/utils/request'

// 查询裤子管理列表
export function listPants(query) {
  return request({
    url: '/clothes/pants/list',
    method: 'get',
    params: query
  })
}

// 查询裤子管理详细
export function getPants(pantsId) {
  return request({
    url: '/clothes/pants/' + pantsId,
    method: 'get'
  })
}

// 新增裤子管理
export function addPants(data) {
  return request({
    url: '/clothes/pants',
    method: 'post',
    data: data
  })
}

// 修改裤子管理
export function updatePants(data) {
  return request({
    url: '/clothes/pants',
    method: 'put',
    data: data
  })
}

// 删除裤子管理
export function delPants(pantsId) {
  return request({
    url: '/clothes/pants/' + pantsId,
    method: 'delete'
  })
}
