import request from '@/utils/request'

// 查询点赞管理列表
export function listLikes(query) {
  return request({
    url: '/community/likes/list',
    method: 'get',
    params: query
  })
}

// 查询点赞管理详细
export function getLikes(likesId) {
  return request({
    url: '/community/likes/' + likesId,
    method: 'get'
  })
}

// 新增点赞管理
export function addLikes(data) {
  return request({
    url: '/community/likes',
    method: 'post',
    data: data
  })
}

// 修改点赞管理
export function updateLikes(data) {
  return request({
    url: '/community/likes',
    method: 'put',
    data: data
  })
}

// 删除点赞管理
export function delLikes(likesId) {
  return request({
    url: '/community/likes/' + likesId,
    method: 'delete'
  })
}
